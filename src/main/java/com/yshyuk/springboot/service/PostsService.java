package com.yshyuk.springboot.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yshyuk.springboot.domain.posts.PostsRepository;
import com.yshyuk.springboot.web.DTO.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
}
