package com.anyview.codec.pojo.response;

import java.io.Serializable;
/**
 * 
 * @author 李海峰
 */
public class PkSaveExerciseResponse implements Serializable {
	 private static final long serialVersionUID = 1L;
	 private SaveExerciseEnum saveExerciseEnumState;
		private String contextID;
		
		public static enum SaveExerciseEnum {
			SaveSuccess,
			
		}

	
		public String getContextID() {
			return contextID;
		}

		public void setContextID(String contextID) {
			this.contextID = contextID;
		}

		public SaveExerciseEnum getSaveExerciseEnumState() {
			return saveExerciseEnumState;
		}

		public void setSaveExerciseEnumState(SaveExerciseEnum saveExerciseEnumState) {
			this.saveExerciseEnumState = saveExerciseEnumState;
		}

		
}
