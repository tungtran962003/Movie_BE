package com.example.movie_web_be.service.impl;

import com.example.movie_web_be.entity.*;
import com.example.movie_web_be.repository.AccountRepository;
import com.example.movie_web_be.response.MessageResponse;
import com.example.movie_web_be.service.AccountService;
import com.example.movie_web_be.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private final String uploadDir = "./src/main/resources/static/assets/avatar/";

    @Override
    public List<Account> getAll() {
        return accountRepository.findAllByIsActiveOrderByIdDesc(true);
    }

    @Override
    public Page<Account> getPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return accountRepository.findAllByIsActiveOrderByIdDesc(pageable, true);
    }

    public Boolean checkEmailExists(String email) {
        return accountRepository.existsAccountByEmail(email);
    }

    public Boolean checkPhoneNumberExists(String phoneNumber) {
        return accountRepository.existsAccountByPhoneNumber(phoneNumber);
    }

    @Override
    public MessageResponse create(String name, String email, String password, Boolean gender, String birthDay, String phoneNumber, Integer rankCustomerId, Integer roleId, MultipartFile file) throws ParseException {
        if (checkEmailExists(email)) {
            return new MessageResponse("Email đã tồn tại", 1);
        }
        if (checkPhoneNumberExists(phoneNumber)) {
            return new MessageResponse("Số điện thoại đã tồn tại", 1);
        }
        Account account = new Account();
        account.setCreateDate(new Date());
        account.setUpdateDate(new Date());
        account.setName(name);
        account.setEmail(email);
        account.setBirthDay(sdf.parse(birthDay));
        account.setGender(gender);
        account.setIsActive(true);
        account.setPassword(passwordEncoder.encode(password));
        account.setPhoneNumber(phoneNumber);
        account.setRankCustomer(RankCustomer.builder().id(rankCustomerId).build());
        account.setRole(Role.builder().id(roleId).build());
        String fileName = file.getOriginalFilename();
        String extension = FileUtil.getFileExtension(fileName);
        String newFileName = "avatar" + new Date().getTime() + "." + extension;
        FileUtil.copyFile(file, newFileName, uploadDir);
        account.setAvatar(newFileName);
        accountRepository.save(account);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse update(Integer idUpdate, String name, String email, String password, Boolean gender, String birthDay, String phoneNumber, Integer rankCustomerId, Integer roleId, MultipartFile file) throws ParseException {
        Account account = accountRepository.findById(idUpdate).get();
        if (account == null) {
            return new MessageResponse("Tài khoản không tồn tại", 1);
        }
        if (checkEmailExists(email)) {
            return new MessageResponse("Email đã tồn tại", 1);
        }
        if (checkPhoneNumberExists(phoneNumber)) {
            return new MessageResponse("Số điện thoại đã tồn tại", 1);
        }
        account.setUpdateDate(new Date());
        account.setName(name);
        account.setEmail(email);
        account.setBirthDay(sdf.parse(birthDay));
        account.setGender(gender);
        account.setPassword(passwordEncoder.encode(password));
        account.setPhoneNumber(phoneNumber);
        account.setRankCustomer(RankCustomer.builder().id(rankCustomerId).build());
        account.setRole(Role.builder().id(roleId).build());
        String fileName = file.getOriginalFilename();
        String extension = FileUtil.getFileExtension(fileName);
        String newFileName = "avatar" + new Date().getTime() + "." + extension;
        FileUtil.copyFile(file, newFileName, uploadDir);
        account.setAvatar(newFileName);
        accountRepository.save(account);
        return new MessageResponse("Thêm dữ liệu thành công", 0);
    }

    @Override
    public MessageResponse delete(Integer idDelete) {
        Account account = accountRepository.findById(idDelete).get();
        if (account == null) {
            return new MessageResponse("Tài khoản không tồn tại", 1);
        }
        account.setIsActive(false);
        accountRepository.save(account);
        return new MessageResponse("Xóa dữ liệu thành công", 0);
    }

}
