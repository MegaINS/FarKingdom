package ru.megains.farlands.network.packet;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

public class PacketBuffer extends ByteBuf {
    private final ByteBuf buf;
    private static final String __OBFID = "CL_00001251";

    public PacketBuffer(ByteBuf p_i45154_1_) {
        this.buf = p_i45154_1_;
    }



//    public void writeItemUser(ItemUser item)throws IOException {
//        writeInt(item.id());
//        writeStringToBuffer(item.name());
//        writeStringToBuffer(item.img());
//        writeInt(item.amount());
//        writeByte(item.action().id());
//        writeByte(item.slot().id());
//    }
//
//
//    public void writeItem(Item item)throws IOException {
//        writeInt(item.id());
//        writeStringToBuffer(item.name());
//        writeStringToBuffer(item.img());
//    }







    /**
     * Writes a compressed NBTTagCompound to this buffer
     */
//    public void writeNBTTagCompoundToBuffer(NBTTagCompound p_150786_1_) throws IOException
//    {
//        if (p_150786_1_ == null)
//        {
//            this.writeShort(-1);
//        }
//        else
//        {
//            byte[] var2 = CompressedStreamTools.compress(p_150786_1_);
//            this.writeShort((short)var2.length);
//            this.writeBytes(var2);
//        }
//    }

    /**
     * Reads a compressed NBTTagCompound from this buffer
     */
//    public NBTTagCompound readNBTTagCompoundFromBuffer() throws IOException
//    {
//        short var1 = this.readShort();
//
//        if (var1 < 0)
//        {
//            return null;
//        }
//        else
//        {
//            byte[] var2 = new byte[var1];
//            this.readBytes(var2);
//            return CompressedStreamTools.func_152457_a(var2, new NBTSizeTracker(2097152L));
//        }
//    }

    /**
     * Writes the ItemStack's ID (short), then size (byte), then damage. (short)
     */






    public String readStringFromBuffer(int p_150789_1_) throws IOException {
        int var2 = this.readShort();

        if (var2 > p_150789_1_ * 4) {
            throw new IOException("The received encoded string buffer length is longer than maximum allowed (" + var2 + " > " + p_150789_1_ * 4 + ")");
        } else if (var2 < 0) {
            throw new IOException("The received encoded string buffer length is less than zero! Weird string!");
        } else {
            String var3 = new String(this.readBytes(var2).array());

            if (var3.length() > p_150789_1_) {
                throw new IOException("The received string length is longer than maximum allowed (" + var2 + " > " + p_150789_1_ + ")");
            } else {
                return var3;
            }
        }
    }


    public void writeStringToBuffer(String p_150785_1_) throws IOException {
        byte[] var2 = p_150785_1_.getBytes();

        if (var2.length > 32767) {
            throw new IOException("String too big (was " + p_150785_1_.length() + " bytes encoded, max " + 32767 + ")");
        } else {
            this.writeShort(var2.length);
            this.writeBytes(var2);
        }
    }

    public int capacity() {
        return this.buf.capacity();
    }

    public ByteBuf capacity(int p_capacity_1_) {
        return this.buf.capacity(p_capacity_1_);
    }

    public int maxCapacity() {
        return this.buf.maxCapacity();
    }

    public ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    public ByteOrder order() {
        return this.buf.order();
    }

    public ByteBuf order(ByteOrder p_order_1_) {
        return this.buf.order(p_order_1_);
    }

    public ByteBuf unwrap() {
        return this.buf.unwrap();
    }

    public boolean isDirect() {
        return this.buf.isDirect();
    }

    public int readerIndex() {
        return this.buf.readerIndex();
    }

    public ByteBuf readerIndex(int p_readerIndex_1_) {
        return this.buf.readerIndex(p_readerIndex_1_);
    }

    public int writerIndex() {
        return this.buf.writerIndex();
    }

    public ByteBuf writerIndex(int p_writerIndex_1_) {
        return this.buf.writerIndex(p_writerIndex_1_);
    }

    public ByteBuf setIndex(int p_setIndex_1_, int p_setIndex_2_) {
        return this.buf.setIndex(p_setIndex_1_, p_setIndex_2_);
    }

    public int readableBytes() {
        return this.buf.readableBytes();
    }

    public int writableBytes() {
        return this.buf.writableBytes();
    }

    public int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    public boolean isReadable() {
        return this.buf.isReadable();
    }

    public boolean isReadable(int p_isReadable_1_) {
        return this.buf.isReadable(p_isReadable_1_);
    }

    public boolean isWritable() {
        return this.buf.isWritable();
    }

    public boolean isWritable(int p_isWritable_1_) {
        return this.buf.isWritable(p_isWritable_1_);
    }

    public ByteBuf clear() {
        return this.buf.clear();
    }

    public ByteBuf markReaderIndex() {
        return this.buf.markReaderIndex();
    }

    public ByteBuf resetReaderIndex() {
        return this.buf.resetReaderIndex();
    }

    public ByteBuf markWriterIndex() {
        return this.buf.markWriterIndex();
    }

    public ByteBuf resetWriterIndex() {
        return this.buf.resetWriterIndex();
    }

    public ByteBuf discardReadBytes() {
        return this.buf.discardReadBytes();
    }

    public ByteBuf discardSomeReadBytes() {
        return this.buf.discardSomeReadBytes();
    }

    public ByteBuf ensureWritable(int p_ensureWritable_1_) {
        return this.buf.ensureWritable(p_ensureWritable_1_);
    }

    public int ensureWritable(int p_ensureWritable_1_, boolean p_ensureWritable_2_) {
        return this.buf.ensureWritable(p_ensureWritable_1_, p_ensureWritable_2_);
    }

    public boolean getBoolean(int p_getBoolean_1_) {
        return this.buf.getBoolean(p_getBoolean_1_);
    }

    public byte getByte(int p_getByte_1_) {
        return this.buf.getByte(p_getByte_1_);
    }

    public short getUnsignedByte(int p_getUnsignedByte_1_) {
        return this.buf.getUnsignedByte(p_getUnsignedByte_1_);
    }

    public short getShort(int p_getShort_1_) {
        return this.buf.getShort(p_getShort_1_);
    }

    public int getUnsignedShort(int p_getUnsignedShort_1_) {
        return this.buf.getUnsignedShort(p_getUnsignedShort_1_);
    }

    public int getMedium(int p_getMedium_1_) {
        return this.buf.getMedium(p_getMedium_1_);
    }

    public int getUnsignedMedium(int p_getUnsignedMedium_1_) {
        return this.buf.getUnsignedMedium(p_getUnsignedMedium_1_);
    }

    public int getInt(int p_getInt_1_) {
        return this.buf.getInt(p_getInt_1_);
    }

    public long getUnsignedInt(int p_getUnsignedInt_1_) {
        return this.buf.getUnsignedInt(p_getUnsignedInt_1_);
    }

    public long getLong(int p_getLong_1_) {
        return this.buf.getLong(p_getLong_1_);
    }

    public char getChar(int p_getChar_1_) {
        return this.buf.getChar(p_getChar_1_);
    }

    public float getFloat(int p_getFloat_1_) {
        return this.buf.getFloat(p_getFloat_1_);
    }

    public double getDouble(int p_getDouble_1_) {
        return this.buf.getDouble(p_getDouble_1_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_) {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_, int p_getBytes_3_) {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_, int p_getBytes_3_, int p_getBytes_4_) {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_, p_getBytes_4_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, byte[] p_getBytes_2_) {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, byte[] p_getBytes_2_, int p_getBytes_3_, int p_getBytes_4_) {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_, p_getBytes_4_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, ByteBuffer p_getBytes_2_) {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_);
    }

    public ByteBuf getBytes(int p_getBytes_1_, OutputStream p_getBytes_2_, int p_getBytes_3_) throws IOException {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_);
    }

    public int getBytes(int p_getBytes_1_, GatheringByteChannel p_getBytes_2_, int p_getBytes_3_) throws IOException {
        return this.buf.getBytes(p_getBytes_1_, p_getBytes_2_, p_getBytes_3_);
    }

    public ByteBuf setBoolean(int p_setBoolean_1_, boolean p_setBoolean_2_) {
        return this.buf.setBoolean(p_setBoolean_1_, p_setBoolean_2_);
    }

    public ByteBuf setByte(int p_setByte_1_, int p_setByte_2_) {
        return this.buf.setByte(p_setByte_1_, p_setByte_2_);
    }

    public ByteBuf setShort(int p_setShort_1_, int p_setShort_2_) {
        return this.buf.setShort(p_setShort_1_, p_setShort_2_);
    }

    public ByteBuf setMedium(int p_setMedium_1_, int p_setMedium_2_) {
        return this.buf.setMedium(p_setMedium_1_, p_setMedium_2_);
    }

    public ByteBuf setInt(int p_setInt_1_, int p_setInt_2_) {
        return this.buf.setInt(p_setInt_1_, p_setInt_2_);
    }

    public ByteBuf setLong(int p_setLong_1_, long p_setLong_2_) {
        return this.buf.setLong(p_setLong_1_, p_setLong_2_);
    }

    public ByteBuf setChar(int p_setChar_1_, int p_setChar_2_) {
        return this.buf.setChar(p_setChar_1_, p_setChar_2_);
    }

    public ByteBuf setFloat(int p_setFloat_1_, float p_setFloat_2_) {
        return this.buf.setFloat(p_setFloat_1_, p_setFloat_2_);
    }

    public ByteBuf setDouble(int p_setDouble_1_, double p_setDouble_2_) {
        return this.buf.setDouble(p_setDouble_1_, p_setDouble_2_);
    }

    public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_) {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_);
    }

    public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_, int p_setBytes_3_) {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_);
    }

    public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_, int p_setBytes_3_, int p_setBytes_4_) {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_, p_setBytes_4_);
    }

    public ByteBuf setBytes(int p_setBytes_1_, byte[] p_setBytes_2_) {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_);
    }

    public ByteBuf setBytes(int p_setBytes_1_, byte[] p_setBytes_2_, int p_setBytes_3_, int p_setBytes_4_) {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_, p_setBytes_4_);
    }

    public ByteBuf setBytes(int p_setBytes_1_, ByteBuffer p_setBytes_2_) {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_);
    }

    public int setBytes(int p_setBytes_1_, InputStream p_setBytes_2_, int p_setBytes_3_) throws IOException {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_);
    }

    public int setBytes(int p_setBytes_1_, ScatteringByteChannel p_setBytes_2_, int p_setBytes_3_) throws IOException {
        return this.buf.setBytes(p_setBytes_1_, p_setBytes_2_, p_setBytes_3_);
    }

    public ByteBuf setZero(int p_setZero_1_, int p_setZero_2_) {
        return this.buf.setZero(p_setZero_1_, p_setZero_2_);
    }

    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    public byte readByte() {
        return this.buf.readByte();
    }

    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    public short readShort() {
        return this.buf.readShort();
    }

    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }

    public int readMedium() {
        return this.buf.readMedium();
    }

    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }

    public int readInt() {
        return this.buf.readInt();
    }

    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }

    public long readLong() {
        return this.buf.readLong();
    }

    public char readChar() {
        return this.buf.readChar();
    }

    public float readFloat() {
        return this.buf.readFloat();
    }

    public double readDouble() {
        return this.buf.readDouble();
    }

    public ByteBuf readBytes(int p_readBytes_1_) {
        return this.buf.readBytes(p_readBytes_1_);
    }

    public ByteBuf readSlice(int p_readSlice_1_) {
        return this.buf.readSlice(p_readSlice_1_);
    }

    public ByteBuf readBytes(ByteBuf p_readBytes_1_) {
        return this.buf.readBytes(p_readBytes_1_);
    }

    public ByteBuf readBytes(ByteBuf p_readBytes_1_, int p_readBytes_2_) {
        return this.buf.readBytes(p_readBytes_1_, p_readBytes_2_);
    }

    public ByteBuf readBytes(ByteBuf p_readBytes_1_, int p_readBytes_2_, int p_readBytes_3_) {
        return this.buf.readBytes(p_readBytes_1_, p_readBytes_2_, p_readBytes_3_);
    }

    public ByteBuf readBytes(byte[] p_readBytes_1_) {
        return this.buf.readBytes(p_readBytes_1_);
    }

    public ByteBuf readBytes(byte[] p_readBytes_1_, int p_readBytes_2_, int p_readBytes_3_) {
        return this.buf.readBytes(p_readBytes_1_, p_readBytes_2_, p_readBytes_3_);
    }

    public ByteBuf readBytes(ByteBuffer p_readBytes_1_) {
        return this.buf.readBytes(p_readBytes_1_);
    }

    public ByteBuf readBytes(OutputStream p_readBytes_1_, int p_readBytes_2_) throws IOException {
        return this.buf.readBytes(p_readBytes_1_, p_readBytes_2_);
    }

    public int readBytes(GatheringByteChannel p_readBytes_1_, int p_readBytes_2_) throws IOException {
        return this.buf.readBytes(p_readBytes_1_, p_readBytes_2_);
    }

    public ByteBuf skipBytes(int p_skipBytes_1_) {
        return this.buf.skipBytes(p_skipBytes_1_);
    }

    public ByteBuf writeBoolean(boolean p_writeBoolean_1_) {
        return this.buf.writeBoolean(p_writeBoolean_1_);
    }

    public ByteBuf writeByte(int p_writeByte_1_) {
        return this.buf.writeByte(p_writeByte_1_);
    }

    public ByteBuf writeShort(int p_writeShort_1_) {
        return this.buf.writeShort(p_writeShort_1_);
    }

    public ByteBuf writeMedium(int p_writeMedium_1_) {
        return this.buf.writeMedium(p_writeMedium_1_);
    }

    public ByteBuf writeInt(int p_writeInt_1_) {
        return this.buf.writeInt(p_writeInt_1_);
    }

    public ByteBuf writeLong(long p_writeLong_1_) {
        return this.buf.writeLong(p_writeLong_1_);
    }

    public ByteBuf writeChar(int p_writeChar_1_) {
        return this.buf.writeChar(p_writeChar_1_);
    }

    public ByteBuf writeFloat(float p_writeFloat_1_) {
        return this.buf.writeFloat(p_writeFloat_1_);
    }

    public ByteBuf writeDouble(double p_writeDouble_1_) {
        return this.buf.writeDouble(p_writeDouble_1_);
    }

    public ByteBuf writeBytes(ByteBuf p_writeBytes_1_) {
        return this.buf.writeBytes(p_writeBytes_1_);
    }

    public ByteBuf writeBytes(ByteBuf p_writeBytes_1_, int p_writeBytes_2_) {
        return this.buf.writeBytes(p_writeBytes_1_, p_writeBytes_2_);
    }

    public ByteBuf writeBytes(ByteBuf p_writeBytes_1_, int p_writeBytes_2_, int p_writeBytes_3_) {
        return this.buf.writeBytes(p_writeBytes_1_, p_writeBytes_2_, p_writeBytes_3_);
    }

    public ByteBuf writeBytes(byte[] p_writeBytes_1_) {
        return this.buf.writeBytes(p_writeBytes_1_);
    }

    public ByteBuf writeBytes(byte[] p_writeBytes_1_, int p_writeBytes_2_, int p_writeBytes_3_) {
        return this.buf.writeBytes(p_writeBytes_1_, p_writeBytes_2_, p_writeBytes_3_);
    }

    public ByteBuf writeBytes(ByteBuffer p_writeBytes_1_) {
        return this.buf.writeBytes(p_writeBytes_1_);
    }

    public int writeBytes(InputStream p_writeBytes_1_, int p_writeBytes_2_) throws IOException {
        return this.buf.writeBytes(p_writeBytes_1_, p_writeBytes_2_);
    }

    public int writeBytes(ScatteringByteChannel p_writeBytes_1_, int p_writeBytes_2_) throws IOException {
        return this.buf.writeBytes(p_writeBytes_1_, p_writeBytes_2_);
    }

    public ByteBuf writeZero(int p_writeZero_1_) {
        return this.buf.writeZero(p_writeZero_1_);
    }

    public int indexOf(int p_indexOf_1_, int p_indexOf_2_, byte p_indexOf_3_) {
        return this.buf.indexOf(p_indexOf_1_, p_indexOf_2_, p_indexOf_3_);
    }

    public int bytesBefore(byte p_bytesBefore_1_) {
        return this.buf.bytesBefore(p_bytesBefore_1_);
    }

    public int bytesBefore(int p_bytesBefore_1_, byte p_bytesBefore_2_) {
        return this.buf.bytesBefore(p_bytesBefore_1_, p_bytesBefore_2_);
    }

    public int bytesBefore(int p_bytesBefore_1_, int p_bytesBefore_2_, byte p_bytesBefore_3_) {
        return this.buf.bytesBefore(p_bytesBefore_1_, p_bytesBefore_2_, p_bytesBefore_3_);
    }

    public int forEachByte(ByteBufProcessor p_forEachByte_1_) {
        return this.buf.forEachByte(p_forEachByte_1_);
    }

    public int forEachByte(int p_forEachByte_1_, int p_forEachByte_2_, ByteBufProcessor p_forEachByte_3_) {
        return this.buf.forEachByte(p_forEachByte_1_, p_forEachByte_2_, p_forEachByte_3_);
    }

    public int forEachByteDesc(ByteBufProcessor p_forEachByteDesc_1_) {
        return this.buf.forEachByteDesc(p_forEachByteDesc_1_);
    }

    public int forEachByteDesc(int p_forEachByteDesc_1_, int p_forEachByteDesc_2_, ByteBufProcessor p_forEachByteDesc_3_) {
        return this.buf.forEachByteDesc(p_forEachByteDesc_1_, p_forEachByteDesc_2_, p_forEachByteDesc_3_);
    }

    public ByteBuf copy() {
        return this.buf.copy();
    }

    public ByteBuf copy(int p_copy_1_, int p_copy_2_) {
        return this.buf.copy(p_copy_1_, p_copy_2_);
    }

    public ByteBuf slice() {
        return this.buf.slice();
    }

    public ByteBuf slice(int p_slice_1_, int p_slice_2_) {
        return this.buf.slice(p_slice_1_, p_slice_2_);
    }

    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }

    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }

    public ByteBuffer nioBuffer(int p_nioBuffer_1_, int p_nioBuffer_2_) {
        return this.buf.nioBuffer(p_nioBuffer_1_, p_nioBuffer_2_);
    }

    public ByteBuffer internalNioBuffer(int p_internalNioBuffer_1_, int p_internalNioBuffer_2_) {
        return this.buf.internalNioBuffer(p_internalNioBuffer_1_, p_internalNioBuffer_2_);
    }

    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }

    public ByteBuffer[] nioBuffers(int p_nioBuffers_1_, int p_nioBuffers_2_) {
        return this.buf.nioBuffers(p_nioBuffers_1_, p_nioBuffers_2_);
    }

    public boolean hasArray() {
        return this.buf.hasArray();
    }

    public byte[] array() {
        return this.buf.array();
    }

    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    public boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    public long memoryAddress() {
        return this.buf.memoryAddress();
    }

    public String toString(Charset p_toString_1_) {
        return this.buf.toString(p_toString_1_);
    }

    public String toString(int p_toString_1_, int p_toString_2_, Charset p_toString_3_) {
        return this.buf.toString(p_toString_1_, p_toString_2_, p_toString_3_);
    }

    public int hashCode() {
        return this.buf.hashCode();
    }

    public boolean equals(Object p_equals_1_) {
        return this.buf.equals(p_equals_1_);
    }

    public int compareTo(ByteBuf p_compareTo_1_) {
        return this.buf.compareTo(p_compareTo_1_);
    }

    public String toString() {
        return this.buf.toString();
    }

    public ByteBuf retain(int p_retain_1_) {
        return this.buf.retain(p_retain_1_);
    }

    public ByteBuf retain() {
        return this.buf.retain();
    }

    @Override
    public ByteBuf touch() {
        return null;
    }

    @Override
    public ByteBuf touch(Object hint) {
        return null;
    }

    public int refCnt() {
        return this.buf.refCnt();
    }

    public boolean release() {
        return this.buf.release();
    }

    public boolean release(int p_release_1_) {
        return this.buf.release(p_release_1_);
    }
}
