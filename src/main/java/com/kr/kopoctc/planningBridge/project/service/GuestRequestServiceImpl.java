package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.repository.GuestRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestRequestServiceImpl implements GuestRequestService{

    @Autowired
    private GuestRequestRepository guestRequestRepository;
}
