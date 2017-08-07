/**
 * 
 */
package com.hdt.demo.Controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sathiyan
 *
 */

@RestController
public class DemoRestController {
	@RequestMapping(path="/api/ping",method=RequestMethod.GET)
	public String ping() {
		  return "PONG other side 123!!!";
		 }
}
