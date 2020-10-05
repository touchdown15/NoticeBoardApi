package com.cers.noticeboardapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cers.noticeboardapi.model.NoticeBoardModel;

public interface NoticeBoardRepository extends PagingAndSortingRepository <NoticeBoardModel, Long > {

}
