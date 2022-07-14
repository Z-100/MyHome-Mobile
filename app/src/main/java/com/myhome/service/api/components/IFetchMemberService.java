package com.myhome.service.api.components;

import com.myhome.service.api.callback.CallbackEntity;
import com.myhome.service.api.response.Members;

public interface IFetchMemberService {

    void fetchAllMembers(CallbackEntity<Members> callback);

    void insertMember(Integer icon, String name, CallbackEntity<Boolean> callback);

    void deleteMember(Long memberId, CallbackEntity<Boolean> callback);

    void updateMember(Long memberId, Integer icon, String name, CallbackEntity<Boolean> callback);
}
