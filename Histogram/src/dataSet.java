
public class dataSet {
	int data[];
    int size;     //contains the number of items in data
    
    public dataSet() { 
    	
    }
    
    public dataSet(int [] dataInput) {
    	data = dataInput;
    }
    public boolean isMode(int k) { 
    	if (k == 0) {
    		if (data[k] > data[k+1]) {
    			return true;
    		} else return false;
    	} else if (k == data.length) {
    		if (data[k] > data[k+1]) {
    			return true;
    		} else return false;
    	} else {
    		if (data[k]>data[k-1]&&data[k]>data[k+1]) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	
    }
    public int modeIndex() { 
    	int modeIndex = 0;
    	int mode = 0;
    	for(int i = 0; i < data.length;i++) {
    		if (isMode(i)) {
    			if (data[i]>mode) {
    				mode = data[i];
    				modeIndex = i;
    			}
    		}
    	}
    	return modeIndex;
    }
    public void printHistogram(int longestBar, String barchar) { 
    	String line;
    	double lineLength = 0;
    	
    	double mode = data[modeIndex()];
    	for(int i = 0;i < data.length; i++) {
    		line = "";
    		lineLength = 0;
    		for(int j = 0; j<data[i];j++) {
    			lineLength++;
    		}
    
    		int updatedLineLength = (int)Math.round((double)(longestBar/mode) * (double)(lineLength));
    		
    		for (int x = 0; x < updatedLineLength; x++) {
    			line += barchar;
    		}

    		System.out.println(line);
    	}
    }
}
