package com.example.extensions;

import com.example.api.FakeApiUserClient;
import com.example.dto.User;
import com.example.extensions.anno.UserAnno;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;

public class CreateUserExtension implements BeforeEachCallback {

    public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(CreateUserExtension.class);

    private final FakeApiUserClient userClient = new FakeApiUserClient();

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        AnnotationSupport.findAnnotation(context.getRequiredTestMethod(), UserAnno.class)
                .ifPresent(anno -> {
                    User user = userClient.createUser(anno.username(), anno.password());

                    context.getStore(NAMESPACE).put(context.getUniqueId(), user);
                });
    }
}