package com.email.Controller;

import com.email.Service.EmailService;
import com.email.model.EmailRequest;
import com.email.model.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class controller {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
  public String Welcome()
  {
      return "this is my email api";

  }
  //api to send email
   @PostMapping("/")
    public ResponseEntity<?> SendEmail(@RequestBody EmailRequest request)
    {

boolean res=this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());

        System.out.println(request);
if(res)
{
    return ResponseEntity.ok(new EmailResponse("Email sent Successfully"));
}
else {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EmailResponse("Email not sent !!"));
}


    }

}
