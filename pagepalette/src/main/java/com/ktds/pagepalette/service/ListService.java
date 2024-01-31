package com.ktds.pagepalette.service;

import com.ktds.pagepalette.dto.list.ListModifyReq;
import com.ktds.pagepalette.dto.list.ListReq;
import com.ktds.pagepalette.dto.list.ListRes;

import java.util.ArrayList;

public interface ListService {
    public Boolean createList(ListReq req);
    public Boolean modifyList(ListModifyReq req);
    public ArrayList<ListRes> readAll(Long boardId);
}
