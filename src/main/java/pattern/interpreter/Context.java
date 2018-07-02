package pattern.interpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 创建上下文环境
 */
public class Context {
	//待解析的文本内容
	private final StringTokenizer stringTokenizer;
	//当前命令
	private String currentToken;
	//用来存储动态变化的信息内容
	private Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * 构造方法设置解析内容
	 */
	public Context(String text) {
		this.stringTokenizer = new StringTokenizer(text);
	}
	
	/**
	 * 解析文本
	 * @return 解析后的文本
	 */
	public String next(){
		if(this.stringTokenizer.hasMoreTokens()){
			currentToken = this.stringTokenizer.nextToken();
		}else{
			currentToken = null;
		}
		return currentToken;
	}
	/**
	 * 判断命令是否正确
	 */
	public boolean equalsWithCommand(String command){
		return (command == null || !command.equals(this.currentToken));
	}

	/**
	 * 获取当前命令
	 * @return 当前命令
	 */
	public String getCurrentToken(){
		return this.currentToken;
	}
	
	/**
	 * 获得节点内容
	 * @param text 命令
	 * @return 节点内容
	 */
	public String getTokenContent(String text){
		String str = text;
		if(str != null){
			//替换map中动态内容后返回
			Iterator<String> iterator = map.keySet().iterator();
			while(iterator.hasNext()){
				String key = iterator.next();
				Object obj = map.get(key);
				str = str.replaceAll(key, obj.toString());
			}
		}
		return str;
	}
	
	public void put(String key, Object value){
		map.put(key, value);
	}
	
	public void clear(String key){
		map.remove(key);
	}
}
