package com.cricketgullygully.console.dto;

import com.cricketgullygully.console.dto.enums.OutType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OutReason {

	private OutType outType;
	private String message;

	OutReason(OutType outType, String bowler, String fielder) {
		setOutType(outType);
		String outMessage = "";
		switch (outType) {

			case BOWLED:
				outMessage = String.format("b %s", bowler);
				break;
			case CAUGHT:
				if (bowler.equals(fielder))
					outMessage = String.format("c&b %s", bowler);
				else
					outMessage = String.format("c %s, b %s", fielder, bowler);
				break;
			case RUNOUT:
				outMessage = String.format("runout %s", fielder);
				break;
			case STUMP:
				outMessage = String.format("st %s", fielder);
				break;
			case HITWICKET:
				outMessage = "hitwicket";
				break;
			case LBW:
				outMessage = String.format("lbw %s", bowler);
				break;
		}
		setMessage(outMessage);
	}

	@JsonIgnore
	public boolean isWicketToBowler() {
		switch (getOutType()) {

			case BOWLED:
			case CAUGHT:
			case STUMP:
			case LBW:
				return true;
		}
		return false;
	}

}
