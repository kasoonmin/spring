package com.spring.pro30.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.spring.pro30.board.vo.ArticleVO;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO{
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List selectAllArticlesList() throws DataAccessException{
		
		List<ArticleVO> articlesList = articlesList = sqlSession.selectList("mappers.board.selectAllArticlesList");
		return articlesList;
	}

	@Override
	public int insertNewArticle(Map articleMap) throws DataAccessException{
		int articleNO = selectNewArticleNO();
		articleMap.put("articleNO", articleNO);
		sqlSession.insert("mappers.board.insertNewArticle",articleMap);
		return articleNO;
	}
	
	@Override
	public ArticleVO selectArticle(int articleNO) throws DataAccessException {
		return sqlSession.selectOne("mappers.board.selectArticle", articleNO);
	}

	@Override
	public void updateArticle(Map articleMap) throws DataAccessException {
		sqlSession.update("mappers.board.updateArticle", articleMap);
	}

	@Override
	public void deleteArticle(int articleNO) throws DataAccessException {
		sqlSession.delete("mappers.board.deleteArticle", articleNO);
		
	}
	
//	@Override
//	public List selectImageFileList(int articleNO) throws DataAccessException {
//		List<ImageVO> imageFileList = null;
//		imageFileList = sqlSession.selectList("mappers.board.selectImageFileList",articleNO);
//		return imageFileList;
//	}
	
	private int selectNewArticleNO() throws DataAccessException {
		return sqlSession.selectOne("mappers.board.selectNewArticleNO");
	}
	
	private int selectNewImageFileNO() throws DataAccessException {
		return sqlSession.selectOne("mappers.board.selectNewImageFileNO");
	}
	
	
//	@Override
//	public int deleteArticle(int id) throws DataAccessException{
//		int result = sqlSession.delete("mappers.board.deleteArticle", id);
//	return result;
//	}
//	
//	@Override
//	public ArticleVO loginById(ArticleVO articleVO) throws DataAccessException{
//		ArticleVO vo = sqlSession.selectOne("mappers.board.loginById",articleVO);
//		return vo;
//	}
//	
//	@Override
//	public ArticleVO updateArticle(Map articleMap) throws DataAccessException{
//		ArticleVO vo = sqlSession.selectOne("mappers.board.updateArticle",articleMap);
//		return vo;
//	}
//
//	
//	@Override
//	public ArticleVO selectArticle(int articleNO) throws DataAccessException{
//		ArticleVO vo = sqlSession.selectOne("mappers.board.selectArticle",articleNO);
//		return vo;
//	}
		

}
