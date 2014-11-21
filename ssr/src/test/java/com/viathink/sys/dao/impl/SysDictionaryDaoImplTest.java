package com.viathink.sys.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.viathink.frame.core.status.EnumDictionaryType;
import com.viathink.frame.core.status.EnumStatus;
import com.viathink.sys.dao.SysDictionaryDao;
import com.viathink.sys.domain.SysDictionary;
import com.viathink.sys.domain.query.SysDictionaryQuery;
import com.viathink.sys.domain.vo.SysDictionaryVo;

/**
 * 
 * @author LiuJunGuang
 * @date 2014年3月3日下午9:48:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
@Transactional
public class SysDictionaryDaoImplTest {

	@Autowired
	private SysDictionaryDao sysDictionaryDao;

	@Test
	public void testInsert() {
		List<SysDictionary> dicList = new ArrayList<SysDictionary>();
		for (int i = 0; i < 10; i++) {
			SysDictionary dic = new SysDictionary();
			dic.setDicGroup("group" + i);
			dic.setDicId("id" + i);
			dic.setDicName("name" + i);
			dic.setDicOrder(i);
			dic.setDicParentId("parendId" + i);
			dic.setDicStatus(EnumStatus.OFF);
			dic.setDicType(EnumDictionaryType.DIR);
			dic.setDicValue("value" + i);
			dicList.add(dic);
		}
		sysDictionaryDao.insertInBatch(dicList);
	}

	@Test
	public void testSelectOne() {
		testInsert();
		SysDictionaryQuery dic = new SysDictionaryQuery();
		dic.setDicId("id1");
		SysDictionaryVo dicVo = sysDictionaryDao.selectOne(dic);
		Assert.assertEquals("id1", dicVo.getDicId());
		Assert.assertEquals("name1", dicVo.getDicName());
	}

	@Test
	public void testSelectById() {
		testInsert();
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id1");
		Assert.assertNotNull(dicVo);
		Assert.assertEquals("id1", dicVo.getDicId());
		Assert.assertEquals("name1", dicVo.getDicName());
	}

	@Test
	public void testSelectListT() {
		testInsert();
		Assert.assertNotNull(sysDictionaryDao.selectList(null));
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicGroupLike("group");
		List<SysDictionaryVo> dicVoList = sysDictionaryDao.selectList(dicQ);
		Assert.assertEquals(10, dicVoList.size());
	}

	@Test
	public void testSelectListTPageable() {
		testInsert();
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicNameLike("name");
		Pageable page = new PageRequest(1, 5, Direction.ASC, "dicOrder");
		List<SysDictionary> dicList = sysDictionaryDao.selectList(dicQ, page);
		Assert.assertEquals(5, dicList.size());
	}

	@Test
	public void testSelectPageList() {
		testInsert();
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicNameLike("name");
		Pageable page = new PageRequest(1, 5, Direction.ASC, "dicOrder");
		Page<SysDictionaryVo> dicVoPage = sysDictionaryDao.selectPageList(dicQ, page);
		Assert.assertEquals(5, dicVoPage.getContent().size());
	}

	@Test
	public void testSelectMap() {
		testInsert();
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicNameLike("name");
		Pageable page = new PageRequest(0, 5);
		Map<String, SysDictionaryVo> dicVoMap = sysDictionaryDao.selectMap(dicQ, "dicId", page);
		Assert.assertEquals(5, dicVoMap.size());
		dicVoMap = sysDictionaryDao.selectMap(dicQ, "dicId", null);
		Assert.assertEquals(10, dicVoMap.size());
	}

	@Test
	public void testSelectAll() {
		testInsert();
		List<SysDictionaryVo> dicVoList = sysDictionaryDao.selectAll();
		Assert.assertEquals(10, dicVoList.size());
	}

	@Test
	public void testSelectCount() {
		testInsert();
		long count = sysDictionaryDao.selectCount();
		Assert.assertEquals(10, count);
	}

	@Test
	public void testSelectCountT() {
		testInsert();
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicNameLike("name");
		long count = sysDictionaryDao.selectCount(dicQ);
		Assert.assertEquals(10, count);
	}

	@Test
	public void testUpdateById() {
		testInsert();
		SysDictionaryQuery dic = new SysDictionaryQuery();
		dic.setDicOrder(3);
		dic.setDicId("id5");
		int count = sysDictionaryDao.updateById(dic);
		Assert.assertEquals(1, count);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id5");
		Assert.assertEquals(new Integer(3), dicVo.getDicOrder());
		Assert.assertEquals(null, dicVo.getDicName());
		Assert.assertEquals(null, dicVo.getDicGroup());
	}

	@Test
	public void testUpdateByIdSelective() {
		testInsert();
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicOrder(4);
		dicQ.setDicId("id3");
		int count = sysDictionaryDao.updateByIdSelective(dicQ);
		Assert.assertEquals(1, count);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id3");
		Assert.assertEquals(new Integer(4), dicVo.getDicOrder());
		Assert.assertEquals("name3", dicVo.getDicName());
		Assert.assertNotEquals(null, dicVo.getDicGroup());
	}

	@Test
	public void testDelete() {
		testInsert();
		SysDictionaryQuery dicQ = new SysDictionaryQuery();
		dicQ.setDicOrder(2);
		dicQ.setDicNameLike("name2");
		int count = sysDictionaryDao.delete(dicQ);
		Assert.assertEquals(1, count);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id2");
		Assert.assertEquals(null, dicVo);
	}

	@Test
	public void testDeleteById() {
		testInsert();
		int count = sysDictionaryDao.deleteById("id5");
		Assert.assertEquals(1, count);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id5");
		Assert.assertEquals(null, dicVo);
	}

	@Test
	public void testBatchDeleteById() {
		testInsert();
		List<String> idList = new ArrayList<String>();
		idList.add("id5");
		idList.add("id6");
		idList.add("id7");
		idList.add("id8");
		sysDictionaryDao.deleteByIdInBatch(idList);
		SysDictionaryVo dicVo = sysDictionaryDao.selectById("id5");
		Assert.assertEquals(null, dicVo);
		SysDictionaryVo dicVo2 = sysDictionaryDao.selectById("id6");
		Assert.assertEquals(null, dicVo2);
		SysDictionaryVo dicVo3 = sysDictionaryDao.selectById("id7");
		Assert.assertEquals(null, dicVo3);
		SysDictionaryVo dicVo8 = sysDictionaryDao.selectById("id8");
		Assert.assertEquals(null, dicVo8);
	}

	@Test
	public void testDeleteAll() {
		testInsert();
		int count = sysDictionaryDao.deleteAll();
		Assert.assertEquals(10, count);
	}

}
