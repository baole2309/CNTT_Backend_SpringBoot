package com.web.cntt.service;

import com.web.cntt.dto.QuyCheDTO;
import com.web.cntt.model.QuyChe;
import java.util.List;

public interface IQuyCheService {
    public List<QuyChe> getAllQuyChe();
    public QuyChe getSQuyCheById(String id);
    public QuyChe addQuyChe(QuyCheDTO request);
    public QuyChe updateQuyChe(QuyCheDTO request, String id);
    public void deleteQuyChe(String id);

}
