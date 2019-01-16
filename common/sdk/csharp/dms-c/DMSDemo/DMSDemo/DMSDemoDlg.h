
// DMSDemoDlg.h : 头文件
//

#pragma once

#include "DMSAsyncApi.h"
#define WM_DESTORY_DMS (WM_USER+100)

// CDMSDemoDlg 对话框
class CDMSDemoDlg : public CDialogEx
{
// 构造
public:
	CDMSDemoDlg(CWnd* pParent = NULL);	// 标准构造函数

// 对话框数据
	enum { IDD = IDD_DMSDEMO_DIALOG };

	protected:
	virtual void DoDataExchange(CDataExchange* pDX);	// DDX/DDV 支持

	void AppendMessage(CString msg);
	int AddSubTopic(CString topic);
	int RemoveSubTopic(CString topic);
	void Reset();
	static CString MultiByteToCString(const char * mb, size_t length);
	static char* CStringToMultiByte(CString str, size_t* pLength = NULL);
	//回调函数
	static void connectionLost(void* context, char* cause);
	static int messageArrived(void *context, char *topicName, int topicLen, DMSAsync_message *message);
	static void deliveryComplete(void* context, DMSAsync_token token);
	static void onConnectSuccess(void* context, DMSAsync_successData* response);
	static void onConnectFailure(void* context, DMSAsync_failureData* response);
	static void onSubscribeSuccess(void* context, DMSAsync_successData* response);
	static void onSubscribeFailure(void* context, DMSAsync_failureData* response);
	static void onUnsubscribeSuccess(void* context, DMSAsync_successData* response);
	static void onUnsubscribeFailure(void* context, DMSAsync_failureData* response);
	static void onSendSuccess(void* context, DMSAsync_successData* response);
	static void onSendFailure(void* context, DMSAsync_failureData* response);
	static void onDisconnectSuccess(void* context, DMSAsync_successData* response);
	static void onDisconnectFailure(void* context, DMSAsync_failureData* response);

// 实现
protected:
	static CDMSDemoDlg* s_pDlg;
	HICON m_hIcon;
	DMSAsync m_client;

	// 生成的消息映射函数
	virtual BOOL OnInitDialog();
	afx_msg void OnPaint();
	afx_msg HCURSOR OnQueryDragIcon();
	DECLARE_MESSAGE_MAP()
public:
	afx_msg void OnBnClickedBtnConnect();
	afx_msg void OnBnClickedBtnSubscribe();
	afx_msg void OnBnClickedBtnSend();
	afx_msg void OnClose();
	virtual void PostNcDestroy();
	afx_msg void OnBnClickedBtnUnsubscribe();
	afx_msg void OnBnClickedBtnClear();
protected:
	afx_msg LRESULT OnDestoryDms(WPARAM wParam, LPARAM lParam);
public:
	afx_msg void OnBnClickedBtnDisconnect();
};
