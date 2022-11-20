package com.example.testsvisitomcore.status.service;

import com.example.testsvisitomcore.status.repository.StatusRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
public abstract class StatusBaseService {

    @Autowired
    protected StatusRepository statusRepository = null;

    protected String parseErrorMessage(String pattern, String message, String prefixConst) {
        int beginIndex = message.indexOf(pattern);
        if (beginIndex == -1) return null;

        beginIndex += pattern.length();
        int endIndex = message.indexOf("\n");

        return message
                .substring(beginIndex, endIndex)
                .replace(prefixConst, "")
                .replace("\"", "");
    }
}
