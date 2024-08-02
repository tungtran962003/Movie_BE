package com.example.movie_web_be.service;

import com.example.movie_web_be.entity.Voucher;
import com.example.movie_web_be.request.VoucherRequest;
import com.example.movie_web_be.response.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface VoucherService {

    List<Voucher> getAll();

    Page<Voucher> getPage(Integer page, Integer pageSize);

    MessageResponse create(VoucherRequest voucherRequest);

    MessageResponse update(Integer idUpdate, VoucherRequest voucherRequest);

    MessageResponse delete(Integer idDelete);
}
