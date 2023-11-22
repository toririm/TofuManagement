package com.tohu.tohumanagement.Commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.bukkit.entity.Player;

class ChatCommandTest {

    @Test
    @DisplayName("mockPlayer1からmockPlayer2に tofu chat コマンドを使用する")
    void chatCommand() {
        Player mockPlayer1 = mock(Player.class);
        Player mockPlayer2 = mock(Player.class);
        String playerName1 = "mockPlayer1";
        String playerName2 = "mockPlayer2";
        when(mockPlayer1.getPlayer()).thenReturn(mockPlayer2);
        when(mockPlayer1.getName()).thenReturn(playerName1);
        when(mockPlayer2.getName()).thenReturn(playerName2);
        String type = "This is message";
        com.tohu.tohumanagement.Commands.ChatCommand.chatCommand(type, playerName2, mockPlayer1);
        verify(mockPlayer2, times(1)).sendMessage("From mockPlayer1: This is message");
    }
}