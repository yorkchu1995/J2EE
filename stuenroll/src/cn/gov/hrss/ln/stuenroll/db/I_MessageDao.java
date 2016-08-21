package cn.gov.hrss.ln.stuenroll.db;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public interface I_MessageDao {
	/**
	 * 发送消息
	 * 
	 * @param name
	 * @param title
	 * @param info
	 * @param writer 
	 * @param writerorg 
	 */
	public int write(String name,String title,String info, String writer, String writerorg);
	
	/**
	 * 专业公告
	 * 
	 * @param organizationName
	 * @param year
	 * @param profession
	 * @param text
	 * @param title
	 * @param list_text
	 * @param time
	 */
	public int writemajormessage(String organizationName,String year,String profession,String text,String title,String list_text,String time);
	
	/**
	 * 收取私邮
	 * 
	 * @param username
	 * @param org
	 * @return
	 */
	public List<Record> receive(String username,String org,int type);
	/**
	 * 删除消息sys_news By _id
	 * 
	 * @param id
	 * @return
	 */
	public int delect(String id);
	/**
	 * 查询消息数量
	 * 
	 * @param id
	 * @return
	 */
	public List<Record> query(int type,String userid,String username);
	/**
	 * 查询结束更新系统时间
	 * 
	 * @param type
	 */
	public void refresh_time(String userid,int type);
	
}
