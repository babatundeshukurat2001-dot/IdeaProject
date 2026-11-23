package ng.greetings.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/shukus/{name}/{age}")
    public String hello(@PathVariable("name") String name, @PathVariable("age") int age) {
        return "Hello " + name + ", " +"you are " +  age + " years old";
    }
}