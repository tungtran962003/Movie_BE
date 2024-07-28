//package com.example.movie_web_be.controller.admin;
//
//import com.example.movie_web_be.request.RoomRequest;
//import com.example.movie_web_be.service.RoomService;
//import com.example.movie_web_be.service.ScheduleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/ticket")
//@CrossOrigin(origins = "${my.string.property}")
//public class ScheduleController {
//
//    @Autowired
//    private ScheduleService scheduleService;
//
//    @GetMapping("/all")
//    public ResponseEntity<?> getAll() {
//        return ResponseEntity.ok(scheduleService.getAll());
//    }
//
//    @GetMapping("/page")
//    public ResponseEntity<?> getPage(@RequestParam Integer page,
//                                     @RequestParam Integer pageSize) {
//        return ResponseEntity.ok(scheduleService.getPage(page, pageSize));
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody RoomRequest roomRequest) {
//        return ResponseEntity.ok(scheduleService.create(roomRequest));
//    }
//
//    @PutMapping("/update/{idUpdate}")
//    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody RoomRequest roomRequest) {
//        return ResponseEntity.ok(scheduleService.update(idUpdate, roomRequest));
//    }
//
//    @DeleteMapping("/delete/{idDelete}")
//    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
//        return ResponseEntity.ok(scheduleService.delete(idDelete));
//    }
//}
