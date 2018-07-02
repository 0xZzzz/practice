package pattern.prototype;
/**
 * ԭ�͹���
 * @author 69953213
 *
 */
public class LifeFactoryImpl implements ILifeFactory{

	private static DayLife dayLife = null;
	
	@Override
	public DayLife newInstance() {
		try {
			if(dayLife == null){
				dayLife = new DayLife();
				dayLife.setGetUp("�ߵ���");
				dayLife.setByBus("����������");
				dayLife.setBuyFood("��˾���������");
				dayLife.setNoon("����˯���");
				dayLife.setAfterNoon("���繤��");
				dayLife.setGoHome("�°���");
				dayLife.setNight("ҹ���ʼ");
				return dayLife;
			}else{
				return dayLife.clone();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
