package com.gdm1.teamandplayerwithtesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gdm1
 */
public class TeamAndPlayerTesting
{
    
    @Test
    public void test_T1_TeamIsCreated()
    {
        Team t = new Team("A-Team", 5);
        assertNotNull(t);
    }
    
    @Test
    public void test_T1_TeamNameIsCorrectOnCreation()
    {
        Team t = new Team("A-Team", 5);
        assertEquals("A-Team", t.getName());
    }
    
    @Test
    public void test_T1_NumberOfRequiredPlayersIsCorrectOnCreation()
    {
        Team t = new Team("A-Team", 5);
        assertEquals(5, t.getRequiredNumberOfPlayers());
    }
    
    @Test
    public void test_T2_PlayerIsCreated()
    {
        Player p = new Player("Jimmy", "");
        assertNotNull(p);
    }
    
    @Test
    public void test_T2_PlayerNameIsCorrectOnCreation()
    {
        Player p = new Player("Jimmy", "");
        assertEquals("Jimmy", p.getName());
    }
    
    @Test
    public void test_T2_PlayerPositionIsCorrectOnCreation()
    {
        Player p = new Player("Jimmy", "");
        assertEquals("", p.getPosition());
    }
    
    @Test
    public void test_T3_ExceptionThrownWhenTeamIsCreatedWithBlankName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Team("", 5));
    }
    
    @Test
    public void test_T4_ExceptionThrownWhenTeamIsCreatedWithNegativeNumberOfRequiredPlayers()
    {
        assertThrows(IllegalArgumentException.class, () -> new Team("Z-Team", -4));
    }
    
    @Test
    public void test_T5_ExceptionThrownWhenPlayerIsCreatedWithBlankName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Player("", ""));
    }
    
    @Test
    public void test_T6_ExceptionThrownWhenTeamIsCreatedWithZeroNumberOfRequiredPlayers()
    {
        assertThrows(IllegalArgumentException.class, () -> new Team("Y-Team", 0));
    }
    
    @Test
    public void test_T7_TeamCannotCompeteWhenNoPlayersAdded()
    {
        Team t = new Team("B-Team", 1);
        assertFalse(t.canCompete());
    }
    
    @Test
    public void test_T8_TeamHasCorrectNumberOfPlayersAfterAddingOnePlayer()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        assertEquals(1, t.getPlayers().size());
    }
    
    @Test
    public void test_T8_TeamHasCorrectPlayerAfterAddingOnePlayer()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        assertEquals(p, t.getPlayers().get(0));
    }
    
    @Test
    public void test_T8_TeamCanCompeteAfterAddingTheRequiredNumberOfPlayers()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        assertTrue(t.canCompete());
    }
    
    @Test
    public void test_T8_PlayerHasTheCorrectTeamAfterBeingAddedToTeam()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        assertEquals(t, p.getTeam());
    }
    
    @Test
    public void test_T8_PlayerHasTheCorrectPositionAfterBeingAddedToTeam()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        assertEquals("Defence", p.getPosition());
    }
    
    @Test
    public void test_T9_CannotAddMorePlayersToTeamThanTheRequiredNumber()
    {
        Player p1 = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p1, "Defence");
        Player p2 = new Player("John", "");
        t.addPlayer(p2, "Attack");
        assertEquals(1, t.getPlayers().size());
    }
    
    @Test
    public void test_T9_RedundantPlayerHasNoTeam()
    {
        Player p1 = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p1, "Defence");
        Player p2 = new Player("John", "");
        t.addPlayer(p2, "Attack");
        assertNull(p2.getTeam());
    }
    
    @Test
    public void test_T9_RedundantPlayerHasNoPosition()
    {
        Player p1 = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p1, "Defence");
        Player p2 = new Player("John", "");
        t.addPlayer(p2, "Attack");
        assertEquals("", p2.getPosition());
    }
    
    @Test
    public void test_T9_ExistingPlayersNotReplacedWhenTryingToAddMorePlayersThanTheRequiredNumber()
    {
        Player p1 = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p1, "Defence");
        Player p2 = new Player("John", "");
        t.addPlayer(p2, "Attack");
        assertEquals(p1, t.getPlayers().get(0));
    }
    
    @Test
    public void test_T10_PlayerIsRemovedFromTeam()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        t.removePlayer("Jimmy");
        assertEquals(0, t.getPlayers().size());
    }
    
    @Test
    public void test_T10_TeamCannotCompeteAfterPlayerIsRemoved()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        t.removePlayer("Jimmy");
        assertFalse(t.canCompete());
    }
    
    @Test
    public void test_T10_RemovedPlayerHasNoTeam()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        t.removePlayer("Jimmy");
        assertNull(p.getTeam());
    }
    
    @Test
    public void test_T10_RemovedPlayerHasNoPosition()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        t.removePlayer("Jimmy");
        assertEquals("", p.getPosition());
    }
    
    @Test
    public void test_T11_PlayerCannotBeRemovedTwice()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        t.removePlayer("Jimmy");
        assertNull(t.removePlayer("Jimmy"));
    }
    
    @Test
    public void test_T11_TeamSizeIsUnchangedAfterAttemptingToRemovePlayerTwice()
    {
        Player p = new Player("Jimmy", "");
        Team t = new Team("B-Team", 1);
        t.addPlayer(p, "Defence");
        t.removePlayer("Jimmy");
        t.removePlayer("Jimmy");
        assertEquals(0, t.getPlayers().size());
    }
    
    @Test
    public void test_T12_FirstTeamSizeNotChangedWhenAttemptingToAddPlayerToTwoTeams()
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p = new Player("Jimmy", "");
        t1.addPlayer(p, "Attack");
        t2.addPlayer(p, "Defence");
        assertEquals(1, t1.getPlayers().size());
    }
    
    @Test
    public void test_T12_FirstTeamKeepsPlayerWhenAttemptingToAddPlayerToTwoTeams()
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p = new Player("Jimmy", "");
        t1.addPlayer(p, "Attack");
        t2.addPlayer(p, "Defence");
        assertEquals(p, t1.getPlayers().get(0));
    }
    
    @Test
    public void test_T12_PlayerTeamNotChangedWhenAttemptingToAddPlayerToTwoTeams()
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p = new Player("Jimmy", "");
        t1.addPlayer(p, "Attack");
        t2.addPlayer(p, "Defence");
        assertEquals(t1, p.getTeam());
    }
    
    @Test
    public void test_T12_PlayerPositionNotChangedWhenAttemptingToAddPlayerToTwoTeams()
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p = new Player("Jimmy", "");
        t1.addPlayer(p, "Attack");
        t2.addPlayer(p, "Defence");
        assertEquals("Attack", p.getPosition());
    }
    
    @Test
    public void test_T12_SecondTeamSizeNotChangedWhenAttemptingToAddPlayerToTwoTeams()
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p = new Player("Jimmy", "");
        t1.addPlayer(p, "Attack");
        t2.addPlayer(p, "Defence");
        assertEquals(0, t2.getPlayers().size());
    }
    
    @Test
    public void test_T12_SecondTeamStillCannotCompeteAfterAttemptingToAddPlayerToTwoTeams()
    {
        Team t1 = new Team("A-Team", 5);
        Team t2 = new Team("B-Team", 1);
        Player p = new Player("Jimmy", "");
        t1.addPlayer(p, "Attack");
        t2.addPlayer(p, "Defence");
        assertFalse(t2.canCompete());
    }
    
    @Test
    public void test_T13_TeamSizeDoesNotChangeWhenAttemptingToAddTheSamePlayerToTheSameTeamTwice()
    {
        Team t = new Team("A-Team", 5);
        Player p = new Player("Jimmy", "");
        t.addPlayer(p, "Attack");
        t.addPlayer(p, "Defence");
        assertEquals(1, t.getPlayers().size());
    }
    
    @Test
    public void test_T13_PlayerTeamDoesNotChangeWhenAttemptingToAddTheSamePlayerToTheSameTeamTwice()
    {
        Team t = new Team("A-Team", 5);
        Player p = new Player("Jimmy", "");
        t.addPlayer(p, "Attack");
        t.addPlayer(p, "Defence");
        assertEquals(t, p.getTeam());
    }
    
    @Test
    public void test_T13_PlayerPositionDoesNotChangeWhenAttemptingToAddTheSamePlayerToTheSameTeamTwice()
    {
        Team t = new Team("A-Team", 5);
        Player p = new Player("Jimmy", "");
        t.addPlayer(p, "Attack");
        t.addPlayer(p, "Defence");
        assertEquals("Attack", p.getPosition());
    }
    
    @Test
    public void test_T14_TeamSizeDoesNotChangeWhenAttemptingToAddPlayerInInvalidPosition()
    {
        Team t = new Team("A-Team", 5);
        Player p = new Player("John", "");
        t.addPlayer(p, "Wing");
        assertEquals(0, t.getPlayers().size());
    }
    
    @Test
    public void test_T14_PlayerHasNoTeamAfterAttemptingToAddPlayerInInvalidPosition()
    {
        Team t = new Team("A-Team", 5);
        Player p = new Player("John", "");
        t.addPlayer(p, "Wing");
        assertNull(p.getTeam());
    }
    
    @Test
    public void test_T14_PlayerHasBlankPositionAfterAttemptingToAddPlayerInInvalidPosition()
    {
        Team t = new Team("A-Team", 5);
        Player p = new Player("John", "");
        t.addPlayer(p, "Wing");
        assertEquals("", p.getPosition());
    }
    
}
