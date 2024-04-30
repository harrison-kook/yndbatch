package kr.co.yanadoo.batch.mapper.yanadooMaster;

import kr.co.yanadoo.batch.config.YanadooMasterMapper;

import java.util.HashMap;
import java.util.List;

@YanadooMasterMapper
public interface JabMapper {
    List<HashMap<String, Object>> selectAdditionList(int price);
}
