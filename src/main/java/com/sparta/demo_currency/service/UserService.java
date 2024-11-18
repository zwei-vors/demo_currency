package com.sparta.demo_currency.service;

import com.sparta.demo_currency.dto.UserRequestDto;
import com.sparta.demo_currency.dto.UserResponseDto;
import com.sparta.demo_currency.entity.User;
import com.sparta.demo_currency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponseDto findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("해당 ID에 대한 데이터가 없습니다. 잘못된 ID 값 입니다.");
        }
        return new UserResponseDto(user.get());
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    public UserResponseDto save(UserRequestDto userRequestDto) {
        User savedUser = userRepository.save(userRequestDto.toEntity());
        return new UserResponseDto(savedUser);
    }

}
