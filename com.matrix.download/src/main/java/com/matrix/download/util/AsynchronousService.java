
package com.matrix.download.util;


import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
 
@Service
public class AsynchronousService {;
 
	private AsyncResult<String> result = new AsyncResult<String>("0 correos enviados");
 
	@Async
	public void sendMails(int totalMails) {
		for (int i = 1; i <= totalMails; i++) {
			try {
				sendMail(i);
				result = new AsyncResult<String>("Enviados " + i + " de " + totalMails);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
 
	private void sendMail(int num) throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Mail " + num + " enviado.");
	}
 
	public AsyncResult<String> getResult() {
		return result;
	}
 
	public String getMailsSender() {
            try {
                return result.get();
            } catch (ExecutionException ex) {
                Logger.getLogger(AsynchronousService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
	}
}