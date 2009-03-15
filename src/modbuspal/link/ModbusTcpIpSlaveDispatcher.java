/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modbuspal.link;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import modbuspal.main.ModbusTools;

/**
 *
 * @author avincon
 */
public class ModbusTcpIpSlaveDispatcher
extends ModbusSlaveDispatcher
implements Runnable
{
    private Thread slaveThread;
    private Socket slaveSocket;
    private InputStream slaveInput;
    private OutputStream slaveOutput;

    public ModbusTcpIpSlaveDispatcher(Socket sock)
    throws IOException
    {
        slaveSocket = sock;
        slaveInput = sock.getInputStream();
        slaveOutput = sock.getOutputStream();
    }

    public void start()
    {
        slaveThread = new Thread(this);
        slaveThread.start();
    }

    public void run()
    {
        System.out.println("Start ModubsTcpIpSlaveDispatcher");
        int recv = 0;
        byte[] buffer = new byte[2048];

        try
        {
            while( recv != -1 )
            {
                // read MBAP header:
                recv = slaveInput.read(buffer,0,7);
                if( recv == -1 )
                {
                    continue;
                }
                else if( recv != 7 )
                {
                    throw new IOException();
                }

                // interpret MBAP header:
                int transactionIdentifier = ModbusTools.getUint16(buffer,0);
                int protocolIdentifier = ModbusTools.getUint16(buffer,2);
                int length = ModbusTools.getUint16(buffer,4);
                int uID = ModbusTools.getUint8(buffer,6);
                //System.out.println("tID="+transactionIdentifier+" pID="+protocolIdentifier+" L="+length+" uID="+uID);

                // receive PDU
                int pduLength = length - 1;
                recv = slaveInput.read(buffer, 7, pduLength);
                if( recv == -1 )
                {
                    continue;
                }
                else if( recv != pduLength )
                {
                    throw new IOException("received "+recv+" bytes instead of "+pduLength);
                }

                // interpret PDU and get result:
                pduLength = processPDU(uID,buffer,7,pduLength);

                if( pduLength > 0 )
                {
                    // change length in MBAP
                    ModbusTools.setUint16(buffer,4,pduLength+1);

                    // send all
                    slaveOutput.write(buffer,0, 7+pduLength);
                    slaveOutput.flush();
                }
            }
        }
        catch(IOException ex)
        {
            System.err.println("ModubsTcpIpSlaveDispatcher exception " +ex.getMessage() );
        }

        System.out.println("Stop ModubsTcpIpSlaveDispatcher");
    }


}