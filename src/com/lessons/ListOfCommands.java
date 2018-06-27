package com.lessons;

public enum ListOfCommands {
        addTeam(1,"To add new team enter 1"),
        addPlayer(2,"To add new player enter 2"),
        unique(3,"To show unique players enter 3"),
        byRating(4,"To show players by rating enter 4"),
        deletePlayer(5,"To delete player enter 5"),
        byTeams(6,"To show players by team enter 6"),
        play(7,"To watch football match enter 7"),
        exit(8,"To exit enter 8");

        private final Integer code;
        private String instruction;

    ListOfCommands(Integer code, String instr){
            this.code = code;
            this.instruction = instr;
        }

        public Integer getCode() {
            return code;
        }

        public String getInstruction() {
            return instruction;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

