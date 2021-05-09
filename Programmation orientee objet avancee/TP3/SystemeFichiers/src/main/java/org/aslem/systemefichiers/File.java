package org.aslem.systemefichiers;

class File extends Node {
    private int size;
    
    public File(String name, int size) {
        super(name);
        this.size = size;
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void explore() {
        System.out.println(this.getName());
    }
}
    
