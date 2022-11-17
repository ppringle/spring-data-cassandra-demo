package com.pringweb.cassandra.service;

import com.pringweb.cassandra.domain.InvitationRequest;
import com.pringweb.cassandra.domain.InvitationResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Created by sk on 28/10/18.
 */
public interface InvitationService {

    InvitationResponse createInvitation(InvitationRequest invitationRequest);
    InvitationResponse updateInvitation(InvitationRequest invitationRequest, String invitationId);
    void deleteAllInvitationsForSpecificGuest(String invitationDate, String guestName);
    List<InvitationResponse> getAllInvitationByDate(LocalDate invitationDate);
    List<InvitationResponse> getAllInvitationsForSpecificGuest(LocalDate invitationDate, String guestName);
    InvitationResponse getInvitationForTheGuest(java.time.LocalDate invitationDate, String guestName, UUID invitationId);
}
