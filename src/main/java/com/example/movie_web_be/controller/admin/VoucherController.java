package com.example.movie_web_be.controller.admin;

import com.example.movie_web_be.request.VoucherRequest;
import com.example.movie_web_be.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voucher")
@CrossOrigin(origins = "${my.string.property}")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(voucherService.getAll());
    }

    @GetMapping("/page")
    public ResponseEntity<?> getPage(@RequestParam Integer page,
                                     @RequestParam Integer pageSize) {
        return ResponseEntity.ok(voucherService.getPage(page, pageSize));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.create(voucherRequest));
    }

    @PutMapping("/update/{idUpdate}")
    public ResponseEntity<?> update(@PathVariable Integer idUpdate, @RequestBody VoucherRequest voucherRequest) {
        return ResponseEntity.ok(voucherService.update(idUpdate, voucherRequest));
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<?> delete(@PathVariable Integer idDelete) {
        return ResponseEntity.ok(voucherService.delete(idDelete));
    }
}
