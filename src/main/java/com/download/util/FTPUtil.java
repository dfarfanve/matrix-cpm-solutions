package com.download.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUtil {

   

    public void closeFTPConnection(FTPClient ftpClient) {
        try {
            ftpClient.logout();
            ftpClient.disconnect();
            Logger.getLogger(FTPUtil.class.getName()).log(Level.INFO, "FTP Connection Disconected", ftpClient);
        } catch (IOException ex) {
            Logger.getLogger(FTPUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FTPClient getFTPConnection(String server, int port, String user, String pass) {
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            if (ftpClient.isConnected()) {
                Logger.getLogger(FTPUtil.class.getName()).log(Level.INFO, "FTP Connection Active", ftpClient);
                return ftpClient;
            }
        } catch (IOException ex) {
            Logger.getLogger(FTPUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void uploadDirectory(FTPClient ftpClient,String remoteDirPath, String localParentDir, String remoteParentDir)
            throws IOException {

        File localDir = new File(localParentDir);
        if(localDir!=null){
            File[] subFiles = localDir.listFiles();
        if (subFiles != null && subFiles.length > 0) {
            for (File item : subFiles) {
                String remoteFilePath = remoteDirPath + "/" + remoteParentDir
                        + "/" + item.getName();
                if (remoteParentDir.equals("")) {
                    remoteFilePath = remoteDirPath + "/" + item.getName();
                }

                if (item.isFile()) {
                    String localFilePath = item.getAbsolutePath();
                    System.out.println("About to upload the file: " + localFilePath);
                    boolean uploaded = uploadSingleFile(ftpClient,
                            localFilePath, remoteFilePath);
                    if (uploaded) {
                        System.out.println("UPLOADED a file to: "
                                + remoteFilePath);
                    } else {
                        System.out.println("COULD NOT upload the file: "
                                + localFilePath);
                    }
                } else {
                    // create directory on the server
                    boolean created = ftpClient.makeDirectory(remoteFilePath);
                    if (created) {
                        System.out.println("CREATED the directory: "
                                + remoteFilePath);
                    } else {
                        System.out.println("COULD NOT create the directory: "
                                + remoteFilePath);
                    }

                    // upload the sub directory
                    String parent = remoteParentDir + "/" + item.getName();
                    if (remoteParentDir.equals("")) {
                        parent = item.getName();
                    }

                    localParentDir = item.getAbsolutePath();
                    uploadDirectory(ftpClient, remoteDirPath, localParentDir,
                            parent);
                }
            }
        }
    }
    }

    public static boolean uploadSingleFile(FTPClient ftpClient, String localFilePath, String remoteFilePath) {
        File localFile = null;
        InputStream inputStream = null;
        try {
            localFile = new File(localFilePath);

            inputStream = new FileInputStream(localFile);

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            return ftpClient.storeFile(remoteFilePath, inputStream);
        } catch (IOException io) {
            Logger.getLogger(FTPUtil.class.getName()).log(Level.SEVERE, null, io);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(FTPUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
