package org.znz.service;


import org.znz.dto.common.View;
import org.znz.entity.Custom;

public interface CustomService {
    View createCustomByParams(Integer goodId, Custom custom);

    View updateCustomByParams(Integer customId, Custom custom);

    View deleteCustomById(Integer customId);
}
