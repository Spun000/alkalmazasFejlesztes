package org.openapitools.apiimpl;

import org.openapitools.model.Runner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.openapitools.api.GetRunnersApi;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetRunnersApiImpl implements GetRunnersApi {

    public GetRunnersApiImpl() {
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        System.out.println("qqq");
        return GetRunnersApi.super.getRequest();
    }

    @Override
    public ResponseEntity<List<Runner>> getRunners() {
        System.out.println("valami");
        List<Runner> resp = new ArrayList<>();
        resp.add(new Runner(5, Runner.SexEnum.MALE, 15, "John Runner"));
        resp.add(new Runner(5, Runner.SexEnum.FEMALE, 15, "Jane Runner"));
        return ResponseEntity.ok(resp);
    }
}
