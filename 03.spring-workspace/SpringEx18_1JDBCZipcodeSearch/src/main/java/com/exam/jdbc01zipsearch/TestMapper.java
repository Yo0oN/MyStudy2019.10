package com.exam.jdbc01zipsearch;

import java.util.ArrayList;
import java.util.List;

public interface TestMapper {
	public abstract ArrayList<ZipcodeTO> selectZipcode(String dong);
}
