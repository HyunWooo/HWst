package model.service;

import java.util.List;

import javax.annotation.Resource;

import model.dao.ProDao;
import model.domain.ProVo;

import org.springframework.stereotype.Service;

@Service("pService")
public class ProServiceImpl implements ProService {

	@Resource(name="pDao")
	private ProDao pDao;
	
	@Override
	public List<ProVo> pSelect() {
		return pDao.proSelect();
	}
}
