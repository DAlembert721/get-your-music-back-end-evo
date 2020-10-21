package com.astra.getyourmusic.model.contractSystem;

public enum ContractState {
    UNANSWERED{
        @Override
        public String response(){
            return "Sin respuesta";
        }
        @Override
        public int id(){
            return 0;
        }
    },
    FINALIZED{
        @Override
        public String response(){
            return "Finalizado";
        }
        @Override
        public int id(){
            return 1;
        }
    },
    IN_PROGRESS{
        @Override
        public String response(){
            return "En progreso";
        }
        @Override
        public int id(){
            return 2;
        }
    },
    REJECTED{
        @Override
        public String response(){
            return "Cancelado";
        }
        @Override
        public int id(){
            return 3;
        }
    };

    public abstract String response();
    public abstract int id();
}
