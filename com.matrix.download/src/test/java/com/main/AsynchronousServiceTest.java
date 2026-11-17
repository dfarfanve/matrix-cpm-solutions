package com.main;

import com.matrix.download.util.AsynchronousService;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext-test.xml" })
public class AsynchronousServiceTest {

	@Autowired
	private AsynchronousService testAsynch;

	@Test
	public void sendAsynchronousMails() throws Exception {
		testAsynch.sendMails(10);
		System.out.println(testAsynch.getMailsSender());

		sleepALittle(10000);

		System.out.println(testAsynch.getMailsSender());

		stopSendMails();
	}

	private void stopSendMails() {
		testAsynch.getResult().cancel(true);
	}

	private void sleepALittle(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}