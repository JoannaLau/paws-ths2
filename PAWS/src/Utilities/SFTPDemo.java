package Utilities;

import java.io.File;
import java.io.FileInputStream;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class SFTPDemo {

	private String SFTPHOST = "139.59.108.59";
	private int    SFTPPORT = 22;
	private String SFTPUSER = "root";
	private String SFTPPASS = "paws123123";
	private String SFTPWORKINGDIR = "/images/";
	

	
	
public SFTPDemo(String filepath) {
		
		Session     session     = null;
		Channel     channel     = null;
		ChannelSftp channelSftp = null;
		

        try{
            JSch jsch = new JSch();

            session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
            session.setPassword(SFTPPASS);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelSftp = (ChannelSftp)channel;
            channelSftp.cd(SFTPWORKINGDIR);
            File f = new File("C://News Images//"+filepath);
            channelSftp.put(new FileInputStream(f), f.getName());
}catch(Exception ex){
ex.printStackTrace();
}
 
}
		
		
	}
	

