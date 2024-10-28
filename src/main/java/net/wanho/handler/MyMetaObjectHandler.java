package net.wanho.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import net.wanho.util.CurrentUserUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", () -> new Date(), Date.class);
        this.strictInsertFill(metaObject, "updateTime", () -> new Date(), Date.class);
        this.strictInsertFill(metaObject, "updateBy", ()->CurrentUserUtil.getCurrentUser(), Integer.class);
        this.strictInsertFill(metaObject, "updateBy", ()->CurrentUserUtil.getCurrentUser(), Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", () -> new Date(), Date.class);
        this.strictUpdateFill(metaObject, "updateBy", ()->CurrentUserUtil.getCurrentUser(), Integer.class);
    }
}
