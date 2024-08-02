package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.RankCustomer;
import com.example.movie_web_be.repository.RankCustomerRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.RankCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankCustomerServiceImpl implements RankCustomerService {

    @Autowired
    private RankCustomerRepository rankCustomerRepository;

    @Override
    public List<RankCustomer> getAll() {
        return rankCustomerRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<RankCustomer> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return rankCustomerRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkName(String name) {
        RankCustomer rankCustomer = rankCustomerRepository.findByNameAndIsActive(name, true);
        if (rankCustomer != null) {
            return false;
        }
        return true;
    }

    @Override
    public MessageResponse create(String name, Integer point) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        RankCustomer rankCustomer = new RankCustomer();
        rankCustomer.setName(name);
        rankCustomer.setIsActive(true);
        rankCustomer.setPoint(point);
        rankCustomerRepository.save(rankCustomer);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, String name, Integer point) {
        if (!checkName(name)) {
            return new MessageResponse("Dữ liệu đã tồn tại", 1);
        }
        RankCustomer rankCustomer = rankCustomerRepository.findByIdAndIsActive(idUpdate, true);
        if (rankCustomer != null) {
            rankCustomer.setPoint(point);
            rankCustomer.setName(name);
            rankCustomerRepository.save(rankCustomer);
            return new MessageResponse("Sửa dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        RankCustomer rankCustomer = rankCustomerRepository.findByIdAndIsActive(idDelete, true);
        if (rankCustomer != null) {
            rankCustomer.setIsActive(false);
            rankCustomerRepository.save(rankCustomer);
            return new MessageResponse("Xoá dữ liệu thành công", 0);
        }
        return new MessageResponse("Lỗi", 1);
    }
}
