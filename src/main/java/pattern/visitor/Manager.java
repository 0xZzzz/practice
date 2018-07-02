package pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理人员(手下有其他员工的人)
 */
public class Manager extends Staff {
	//保存手下员工信息
	private final List<Staff> staffList = new ArrayList<Staff>();

	public Manager(String no, String name, String position, float salary) {
		super(no, name, position, salary);
	}

	//增加员工
	@Override
	public void add(Staff staff) {
		this.staffList.add(staff);
	}

	//根据员工号删除员工
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

	//接受访问者对象
	@Override
	public void accept(IVisitor visitor) {
		//访问自身 
		visitor.visit(this);
		for (Staff staff : staffList) {
			if(staff == null){
				continue;
			}
			//接受访问者对象
			staff.accept(visitor);
		}
	}

}
