import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class TankMoveMsg implements Msg {
	int msgType = Msg.TANK_MOVE_MSG;
	int x, y;
	int id;
	Dir dir;
	TankClient tc;
	
	public TankMoveMsg(int id,int x, int y,  Dir dir) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	public TankMoveMsg(TankClient tc) {
		this.tc = tc;
	}

	public void parse(DataInputStream dis) {
		try {
			int id = dis.readInt();
			if(tc.myTank.id == id) {
				return;
			}
			int x = dis.readInt();
			int y = dis.readInt();
			Dir dir = Dir.values()[dis.readInt()];
			
//System.out.println("id:" + id + "-x:" + x + "-y:" + y + "-dir:" + dir + "-good:" + good);
			boolean exist = false;
			for(int i=0; i<tc.tanks.size(); i++) {
				Tank t = tc.tanks.get(i);
				if(t.id == id) {
					t.x = x;
					t.y = y;
					t.dir = dir;
					exist = true;
					break;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void send(DatagramSocket ds, String IP, int udpPort) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeInt(msgType);
			dos.writeInt(id);
			dos.writeInt(x);
			dos.writeInt(y);
			dos.writeInt(dir.ordinal());
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] buf = baos.toByteArray();
		try {
			DatagramPacket dp = new DatagramPacket(buf, buf.length, new InetSocketAddress(IP, udpPort));
			ds.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
