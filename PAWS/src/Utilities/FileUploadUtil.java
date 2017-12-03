package Utilities;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
public class FileUploadUtil {


    public void FileUploadUtil() {
    	
    }    
    
    
    private String SFTPHOST = "128.199.211.133";
	private int    SFTPPORT = 22;
	private String SFTPUSER = "root";
	private String SFTPPASS = "pAws123321pawS";
	private String SFTPWORKINGDIR = "/var/project/images";
	


    


	    public void FileUpload(String file) {
	    

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
	            File f = new File("C://RESOURCES//"+file);
	            channelSftp.put(new FileInputStream(f), f.getName());
			}catch(Exception ex){
			ex.printStackTrace();
			}
			 
			}

	
}
