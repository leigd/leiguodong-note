package com.lgd.note;

import com.lgd.note.util.DBUtil;
import org.junit.Test;

/**
 * @author leiguodong
 * @descirption
 * @date 2021/10/20 22:05
 */
public class TestDBUtil {
    @Test
    public void testDb(){
        System.out.println(DBUtil.getConnection());
    }
}
