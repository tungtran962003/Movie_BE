package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.Voucher;
import com.example.movie_web_be.repository.VoucherRepository;
import com.example.movie_web_be.request.VoucherRequest;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public List<Voucher> getAll() {
        return voucherRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Voucher> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return voucherRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkName(String name) {
        Voucher voucher = voucherRepository.findByNameAndIsActive(name, true);
        if (voucher != null) {
            return false;
        }
        return true;
    }

    public String generateCode() {
        Voucher voucherFinalCurrent = voucherRepository.findTopByOrderByIdDesc();
        if (voucherFinalCurrent == null) {
            return "VC000001";
        }
        Integer idFinalCurrent = voucherFinalCurrent.getId() + 1;
        String code = String.format("%05d", idFinalCurrent);
        return "VC"+code;
    }

    public Date getDateTimeResponse(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, -7);
        return calendar.getTime();
    }

    @Override
    public MessageResponse create(VoucherRequest voucherRequest) {
        if (!checkName(voucherRequest.getName())) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        Voucher voucher = new Voucher();
        voucher.setName(voucherRequest.getName());
        voucher.setCode(generateCode());
        voucher.setStartDate(getDateTimeResponse(voucherRequest.getStartDate()));
        voucher.setEndDate(getDateTimeResponse(voucherRequest.getEndDate()));
        voucher.setQuantity(voucherRequest.getQuantity());
        voucher.setMinimumPrice(voucherRequest.getMinimumPrice());
        voucher.setIsActive(true);
        voucherRepository.save(voucher);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, VoucherRequest voucherRequest) {

        Voucher voucher = voucherRepository.findByIdAndIsActive(idUpdate, true);
        if (voucher != null) {
            if (!voucher.getName().equals(voucherRequest.getName())) {
                if (!checkName(voucherRequest.getName())) {
                    return new MessageResponse("Dữ liệu đã tồn tại", 1);
                }
            }
            voucher.setName(voucherRequest.getName());
            voucher.setStartDate(voucherRequest.getStartDate());
            voucher.setEndDate(voucherRequest.getEndDate());
            voucher.setQuantity(voucherRequest.getQuantity());
            voucher.setMinimumPrice(voucherRequest.getMinimumPrice());
            voucher.setIsActive(true);
            voucherRepository.save(voucher);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Voucher voucher = voucherRepository.findByIdAndIsActive(idDelete, true);
        if (voucher != null) {
            voucher.setIsActive(false);
            voucherRepository.save(voucher);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
