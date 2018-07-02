package pattern.interpreter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * ���������Ļ���
 */
public class Context {
	//���������ı�����
	private final StringTokenizer stringTokenizer;
	//��ǰ����
	private String currentToken;
	//�����洢��̬�仯����Ϣ����
	private Map<String, Object> map = new HashMap<String, Object>();
	
	/**
	 * ���췽�����ý�������
	 */
	public Context(String text) {
		this.stringTokenizer = new StringTokenizer(text);
	}
	
	/**
	 * �����ı�
	 * @return ��������ı�
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
	 * �ж������Ƿ���ȷ
	 */
	public boolean equalsWithCommand(String command){
		return (command == null || !command.equals(this.currentToken));
	}

	/**
	 * ��ȡ��ǰ����
	 * @return ��ǰ����
	 */
	public String getCurrentToken(){
		return this.currentToken;
	}
	
	/**
	 * ��ýڵ�����
	 * @param text ����
	 * @return �ڵ�����
	 */
	public String getTokenContent(String text){
		String str = text;
		if(str != null){
			//�滻map�ж�̬���ݺ󷵻�
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
