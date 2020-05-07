package springBootRestService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springBootRestService.entities.Message;
import springBootRestService.entities.Role;
import springBootRestService.entities.User;
import springBootRestService.exceptions.NotFoundException;
import springBootRestService.repos.MessageRepo;
import springBootRestService.repos.UserRepo;

import java.util.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private MessageRepo messageRepo;

//
//    private int counter = 4;
//
//    private List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
//        add(new HashMap<String, String>() {{ put("id", "1"); put("text", "First message"); }});
//        add(new HashMap<String, String>() {{ put("id", "2"); put("text", "Second message"); }});
//        add(new HashMap<String, String>() {{ put("id", "3"); put("text", "Third message"); }});
//    }};
//
    MultipartFile file;

    class Temp {
        public String message = "ну привет";
    }

    @GetMapping("/test")
    public Temp test() {
        return new Temp();
    }

    @GetMapping("/mes")
    public Iterable<Message> getMessages() {
        Iterable<Message> messages = messageRepo.findAll();
        return messages;
    }

//    @PostMapping("/create")
//    public Message createMessage(@RequestBody Map<String, String> message) {
//        Message mes = new Message(message.get("text"), message.get("tag"));
//        messageRepo.save(mes);
//        return mes;
//    }

//    //security
//    @PostMapping("/create")
//    public Message createMessage(@AuthenticationPrincipal User user, @RequestParam String message, @RequestParam String tag) {
//        Message mes = new Message(message, tag, user);
//        messageRepo.save(mes);
//        return mes;
//    }

    @GetMapping("{tag}")
    public List<Message> filter(@PathVariable String tag) {
        List<Message> messages = messageRepo.findByTag(tag);
        return messages;
    }

//
//    @GetMapping
//    public List<Map<String, String>> list() {
//        return messages;
//    }
//
//    @GetMapping("{id}")
//    public Map<String, String> getOne(@PathVariable String id) {
//        return getMessage(id);
//    }
//
//    private Map<String, String> getMessage(@PathVariable String id) {
//        return messages.stream()
//                .filter(message -> message.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
//
//    @PostMapping
//    public Map<String, String> create(@RequestBody Map<String, String> message) {
//        message.put("id", String.valueOf(counter++));
//
//        messages.add(message);
//
//        return message;
//    }
//
//    @PutMapping("{id}")
//    public Map<String, String> update(@PathVariable String id, @RequestBody Map<String, String> message) {
//        Map<String, String> messageFromDb = getMessage(id);
//
//        messageFromDb.putAll(message);
//        messageFromDb.put("id", id);
//
//        return messageFromDb;
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable String id) {
//        Map<String, String> message = getMessage(id);
//
//        messages.remove(message);
//    }

//
//
//    private final String sharedKey = "SHARED_KEY";
//
//    private static final String SUCCESS_STATUS = "success";
//    private static final String ERROR_STATUS = "error";
//    private static final int CODE_SUCCESS = 100;
//    private static final int AUTH_FAILURE = 102;
//
//    @GetMapping
//    public BaseResponse showStatus() {
//        return new BaseResponse(SUCCESS_STATUS, 1);
//    }
//
//    @PostMapping(value = "/pay")
//    //public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {
//    public BaseResponse pay(@RequestBody PaymentRequest request) {
//        final BaseResponse response;
//
//        //if (sharedKey.equalsIgnoreCase(key)) {
//            int userId = request.getUserId();
//            String itemId = request.getItemId();
//            double discount = request.getDiscount();
//            // Process the request
//            // ....
//            // Return success response to the client.
//            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
////        } else {
////            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
////        }
//        return response;
//    }
}
