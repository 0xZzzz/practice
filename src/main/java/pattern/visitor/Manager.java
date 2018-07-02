package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * ������Ա(����������Ա������)
 */
public class Manager extends Staff {
	//��������Ա����Ϣ
	private final List<Staff> staffList = new ArrayList<Staff>();

	public Manager(String no, String name, String position, float salary) {
		super(no, name, position, salary);
	}

	//����Ա��
	@Override
	public void add(Staff staff) {
		this.staffList.add(staff);
	}

	//����Ա����ɾ��Ա��
	@Override
	public Staff remove(String no) {
		Staff delStaff = null;
		if(no != null && !"".equals(no)){
			for (Staff staff : staffList) {
				if(staff == null){
					continue;
				}
				if(staff.getNo().equals(no)){
					delStaff = staff;
					staffList.remove(staff);
				}
			}
		}
		return delStaff;
	}

	//���ܷ����߶���
	@Override
	public void accept(IVisitor visitor) {
		//�������� 
		visitor.visit(this);
		for (Staff staff : staffList) {
			if(staff == null){
				continue;
			}
			//���ܷ����߶���
			staff.accept(visitor);
		}
	}

}
