package com.eticaret.eticaret4.utils;

import com.eticaret.eticaret4.adminEntities.ProductImages;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Util {

    final DriverManagerDataSource source;
    final HttpServletRequest req;
    final HttpServletResponse res;
    public Util(DriverManagerDataSource source, HttpServletRequest req, HttpServletResponse res) {
        this.source = source;
        this.req = req;
        this.res = res;
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }


    public List<ProductImages> allProduct() {
        List<ProductImages> ls = new ArrayList<>();
        try {

            String sql = "SELECT p.pid, p.cid, p.detail, p.price, p.ptitle, i.image_name as imageName, c.title FROM product as p INNER JOIN image as i ON p.pid = i.pid INNER JOIN category as c ON c.cid = p.cid GROUP BY pid ORDER by pid DESC LIMIT 0 , 10 ";
            PreparedStatement pre = source.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int pid = 0;
            while( rs.next() ) {
                ProductImages i = new ProductImages();
                i.setCid(rs.getInt("cid"));
                i.setDetail(rs.getString("detail"));
                i.setImageName(rs.getString("imageName"));
                i.setPid(rs.getInt("pid"));
                pid = rs.getInt("pid");
                i.setPrice(rs.getDouble("price"));
                i.setPtitle(rs.getString("ptitle"));
                i.setTitle(rs.getString("title"));
                ls.add(i);
            }
        }catch (Exception ex) {

        }
        return ls;
    }


    public String uuidCookie() {
        String uuid = "";

        if ( req.getCookies() != null ) {
            Cookie[] arrs = req.getCookies();
            for ( Cookie cookie : arrs ) {
                if ( cookie.getName().equals("uuid") ) {
                    uuid = cookie.getValue();
                    break;
                }
            }
        }

        if ( uuid.equals("") ) {
            uuid = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("uuid", uuid);
            cookie.setMaxAge(60 * 60 * 24 * 30);
            res.addCookie(cookie);
        }

        return uuid;
    }


    public List<ProductImages> allBasketProduct() {
        List<ProductImages> ls = new ArrayList<>();

        try {
            double tot = 0;
            String sql = "SELECT p.pid, p.cid, p.detail, p.price, p.ptitle, i.image_name as imageName, c.title FROM basket as b INNER JOIN product as p ON b.pid = p.pid INNER JOIN image as i ON p.pid = i.pid INNER JOIN category as c ON c.cid = p.cid WHERE b.uuid = '"+uuidCookie()+"' GROUP BY pid ORDER by pid DESC LIMIT 0 , 10 ";
            PreparedStatement pre = source.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int pid = 0;
            while( rs.next() ) {
                ProductImages i = new ProductImages();
                i.setCid(rs.getInt("cid"));
                i.setDetail(rs.getString("detail"));
                i.setImageName(rs.getString("imageName"));
                i.setPid(rs.getInt("pid"));
                pid = rs.getInt("pid");
                i.setPrice(rs.getDouble("price"));
                i.setPtitle(rs.getString("ptitle"));
                i.setTitle(rs.getString("title"));
                ls.add(i);
                tot += rs.getDouble("price");
            }
            ProductImages endTotal = new ProductImages();
            endTotal.setTotal(tot);
            ls.add(endTotal);

        }catch (Exception ex) {

        }
        return ls;
    }



    public List<ProductImages> allCatID( int cid ) {
        List<ProductImages> ls = new ArrayList<>();
        try {

            String sql = "SELECT p.pid, p.cid, p.detail, p.price, p.ptitle, i.image_name as imageName, c.title FROM product as p INNER JOIN image as i ON p.pid = i.pid INNER JOIN category as c ON c.cid = p.cid WHERE p.cid = '"+cid+"' GROUP BY pid ORDER by pid DESC ";
            PreparedStatement pre = source.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int pid = 0;
            while( rs.next() ) {
                ProductImages i = new ProductImages();
                i.setCid(rs.getInt("cid"));
                i.setDetail(rs.getString("detail"));
                i.setImageName(rs.getString("imageName"));
                i.setPid(rs.getInt("pid"));
                pid = rs.getInt("pid");
                i.setPrice(rs.getDouble("price"));
                i.setPtitle(rs.getString("ptitle"));
                i.setTitle(rs.getString("title"));
                ls.add(i);
            }
        }catch (Exception ex) {

        }
        return ls;
    }

    public List<ProductImages> searchQAndCid( String q, int cid ) {
        List<ProductImages> ls = new ArrayList<>();
        try {

            String sql = "SELECT p.pid, p.cid, p.detail, p.price, p.ptitle, i.image_name as imageName, c.title FROM product as p INNER JOIN image as i ON p.pid = i.pid INNER JOIN category as c ON c.cid = p.cid WHERE (p.ptitle like '%"+q+"%' or p.detail like '%"+q+"%') and p.cid = "+cid+" GROUP BY pid ORDER by pid DESC ";
            PreparedStatement pre = source.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int pid = 0;
            while( rs.next() ) {
                ProductImages i = new ProductImages();
                i.setCid(rs.getInt("cid"));
                i.setDetail(rs.getString("detail"));
                i.setImageName(rs.getString("imageName"));
                i.setPid(rs.getInt("pid"));
                pid = rs.getInt("pid");
                i.setPrice(rs.getDouble("price"));
                i.setPtitle(rs.getString("ptitle"));
                i.setTitle(rs.getString("title"));
                ls.add(i);
            }
        }catch (Exception ex) {

        }
        return ls;
    }


    public List<ProductImages> searchQ( String q) {
        List<ProductImages> ls = new ArrayList<>();
        try {

            String sql = "SELECT p.pid, p.cid, p.detail, p.price, p.ptitle, i.image_name as imageName, c.title FROM product as p INNER JOIN image as i ON p.pid = i.pid INNER JOIN category as c ON c.cid = p.cid WHERE p.ptitle like '%"+q+"%' or p.detail like '%"+q+"%' GROUP BY pid ORDER by pid DESC ";
            PreparedStatement pre = source.getConnection().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            int pid = 0;
            while( rs.next() ) {
                ProductImages i = new ProductImages();
                i.setCid(rs.getInt("cid"));
                i.setDetail(rs.getString("detail"));
                i.setImageName(rs.getString("imageName"));
                i.setPid(rs.getInt("pid"));
                pid = rs.getInt("pid");
                i.setPrice(rs.getDouble("price"));
                i.setPtitle(rs.getString("ptitle"));
                i.setTitle(rs.getString("title"));
                ls.add(i);
            }
        }catch (Exception ex) {

        }
        return ls;
    }


}
